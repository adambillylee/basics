import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        int graph[][] = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int counter = 0;

        // build graph matrix and indegree from input
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int preReq = pair[1];

            // from preReq to course + 1
            if (graph[preReq][course] == 0)
                indegree[preReq]++;

            // mark connection from preReq to course
            graph[preReq][course] = 1;
        }

        // push all nodes with no in degrees into queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            counter++;

            for (int i = 0; i < numCourses; i++) {
                // find all neighbour nodes from curr node
                if (graph[curr][i] > 0) {
                    indegree[i]--;

                    if (graph[curr][i] == 0)
                        queue.offer(i);
                }
            }
        }

        return counter == numCourses;
    }
}