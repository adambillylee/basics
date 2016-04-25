import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int importance[] = new int[numCourses];
        int graph[][] = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int counter = 0;

        // loop throu prereqs to build graph and importance list
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int preReq = pair[1];

            if (graph[preReq][course] == 0)
                importance[course]++;

            graph[preReq][course] = 1;
        }

        // add course of zero importance into queue
        for (int i = 0; i < numCourses; i++) {
            if (importance[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            counter++;
            // System.out.println("pull course: "+curr+" from queue");

            // minus importance of next nodes by 1
            for (int i = 0; i < numCourses; i++) {
                if (graph[curr][i] > 0) {
                    importance[i]--;

                    if (importance[i] == 0)
                        queue.offer(i);
                }
            }
        }

        return counter == numCourses;
    }
}