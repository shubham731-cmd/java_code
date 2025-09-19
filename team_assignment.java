import java.util.*;
public class team_assignment {
    
    public static void main(String[] args) {
        // int[] skills = {10, 20, 30, 40};
        Scanner sc= new Scanner(System.in);
        
        //int n = skills.length;
        int n= sc.nextInt();
        int [] skills=new int[n];
        for(int i=0;i<n;i++){
            skills[i]=sc.nextInt();
        }

        List<Integer> bestTeamA = new ArrayList<>();
        List<Integer> bestTeamB = new ArrayList<>();
        int[] minDiff = {Integer.MAX_VALUE}; // use array so it can be modified inside lambda

        // Stack-based DFS (simulate recursion)
        class State {
            int idx, sumA, sumB;
            List<Integer> teamA, teamB;
            State(int idx, int sumA, int sumB, List<Integer> teamA, List<Integer> teamB) {
                this.idx = idx;
                this.sumA = sumA;
                this.sumB = sumB;
                this.teamA = teamA;
                this.teamB = teamB;
            }
        }

        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0, 0, new ArrayList<>(), new ArrayList<>()));

        while (!stack.isEmpty()) {
            State cur = stack.pop();

            if (cur.idx == n) {
                if (cur.teamA.size() == n / 2 && cur.teamB.size() == n / 2) {
                    int diff = Math.abs(cur.sumA - cur.sumB);
                    if (diff < minDiff[0]) {
                        minDiff[0] = diff;
                        bestTeamA = new ArrayList<>(cur.teamA);
                        bestTeamB = new ArrayList<>(cur.teamB);
                    }
                }
                continue;
            }

            // Option 1: put in Team A
            if (cur.teamA.size() < n / 2) {
                List<Integer> newA = new ArrayList<>(cur.teamA);
                newA.add(skills[cur.idx]);
                stack.push(new State(cur.idx + 1, cur.sumA + skills[cur.idx], cur.sumB, newA, new ArrayList<>(cur.teamB)));
            }

            // Option 2: put in Team B
            if (cur.teamB.size() < n / 2) {
                List<Integer> newB = new ArrayList<>(cur.teamB);
                newB.add(skills[cur.idx]);
                stack.push(new State(cur.idx + 1, cur.sumA, cur.sumB + skills[cur.idx], new ArrayList<>(cur.teamA), newB));
            }
        }

        System.out.print("Team A: ");
        for (int x : bestTeamA) System.out.print(x + " ");
        System.out.print("| Team B: ");
        for (int x : bestTeamB) System.out.print(x + " ");
        sc.close();
    }
}
