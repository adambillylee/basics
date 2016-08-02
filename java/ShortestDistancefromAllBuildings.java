import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adamli on 4/16/16.
 */
public class ShortestDistancefromAllBuildings {
    private class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        /**
         * total sum of distance
         * from pos[i][j]
         * to all existing buildings (grid[i][j] = 1)
         */
        int distSum[][] = new int[m][n];

        // number of building accessible from pos[i][j]
        int accessibleBuildings[][] = new int[m][n];

        // min distance to all buildings
        int min = Integer.MAX_VALUE;

        // count of existing buildings
        int buildings = 0;

        if (m == 0 || n == 0 || grid == null)
            return -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // for all buildings on the map
                if (grid[i][j] == 1) {
                    // add total number of buildings by 1
                    buildings++;

                    /**
                     * add the distance to all empty space to this building to distSum
                     */
                    boolean canVisitAllOtherBuildings = addDistance(grid, distSum, accessibleBuildings, i, j);

                    /**
                     * if there is any building not accessible from this building, return -1 directly
                     */
                    if (!canVisitAllOtherBuildings)
                        return -1;
                }
            }
        }

        // find and return the minimum path
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 1. this pos has to be an empty space
                 * 2. it has to be able to access all buildings
                 * 3. total path sum < current min
                 */
                if (grid[i][j] == 0 && accessibleBuildings[i][j] == buildings && distSum[i][j] < min)
                    min = distSum[i][j];
            }
        }

        return min;
    }

    /**
     * BFS from building to all empty space, add distance to previous result
     * At the same time, check if this building can access all other buildings in the map
     *
     * @param grid    map
     * @param distSum sum of distance from building to that house
     * @param accessibleBuildings  number of building accessible from this position
     * @param i       i coordinate
     * @param j       j coordinate
     * @return Can this building access all other buildings on the map? (grid[i][j] = 1)
     */
    private boolean addDistance(int[][] grid, int[][] distSum, int[][] accessibleBuildings, int i, int j) {
        /**
         * create an visited boolean array to mark if this position is visited or not
         */
        boolean isVisited[][] = new boolean[grid.length][grid[0].length];

        /**
         * create queue for BFS and push current pair into queue
         */
        Queue<Position> queue = new LinkedList<>();
        Position here = new Position(i, j);
        queue.offer(here);


        // BFS
        int distFromHere = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int k = 0; k < len; k++) {
                /**
                 * handle current position
                 */
                Position curr = queue.poll();

                // add sum of distance from here to pos[i][j] total sum
                distSum[curr.row][curr.col] += distFromHere;

                // add accessible building of this position by 1
                accessibleBuildings[curr.row][curr.col]++;

                // find all valid neighbors of current position
                List<Position> neighbors = expend(curr, grid, isVisited);

                queue.addAll(neighbors);
            }
            distFromHere++;
        }

        /**
         * since we mark isVisited[][] = true for all buildings
         * in BFS node extension, all other buildings should have isVisited = true
         * if not, then there are some buildings not accessible from here, return false
         */
        for (int k = 0; k < grid.length; k++) {
            for (int s = 0; s < grid[0].length; s++) {
                if (grid[k][s] == 1 && !isVisited[k][s])
                    return false;
            }
        }

        return true;
    }

    /**
     * decide if a new position is valid
     *
     * @param position  new position
     * @param grid      map
     * @param isVisited visited map of current BST iteration
     * @return valid or not
     */
    private boolean isValidPair(Position position, int[][] grid, boolean isVisited[][]) {
        int m = grid.length;
        int n = grid[0].length;


        if (position.row < 0)
            return false;
        if (position.col < 0)
            return false;

        if (position.row >= m)
            return false;
        if (position.col >= n)
            return false;

        if (isVisited[position.row][position.col])
            return false;

        if (grid[position.row][position.col] > 0) {
            /**
             * even if this position is a building or obstacle, still mark visited as true
             * this is useful to determine if this building is accessible by all other buildings
             */
            isVisited[position.row][position.col] = true;
            return false;
        }

        return true;
    }

    /**
     * create a list of expended pairs from a position
     *
     * @param position  orig position
     * @param grid      map
     * @param isVisited map of visited is current BST iteration
     * @return list of expended pairs
     */
    private List<Position> expend(Position position, int[][] grid, boolean isVisited[][]) {
        List<Position> rst = new ArrayList<>();

        Position up = new Position(position.row - 1, position.col);
        if (isValidPair(up, grid, isVisited)) {
            rst.add(up);
            isVisited[up.row][up.col] = true;
        }

        Position down = new Position(position.row + 1, position.col);
        if (isValidPair(down, grid, isVisited)) {
            rst.add(down);
            isVisited[down.row][down.col] = true;
        }

        Position left = new Position(position.row, position.col - 1);
        if (isValidPair(left, grid, isVisited)) {
            rst.add(left);
            isVisited[left.row][left.col] = true;
        }

        Position right = new Position(position.row, position.col + 1);
        if (isValidPair(right, grid, isVisited)) {
            rst.add(right);
            isVisited[right.row][right.col] = true;
        }

        return rst;
    }
}
