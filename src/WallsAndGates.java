public class WallsAndGates {
    /**
     * https://leetcode.com/problems/walls-and-gates/
     * Trick: start from gates and populate distance in the room
     * loop through all rooms, rewrite the distance with the smaller one
     *
     * @param rooms configuration of room, gate and walls
     */
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                /**
                 * start updating distance from gates to rooms (room[i][j]==0)
                 */
                if (rooms[i][j] == 0) {
                    findDistance(rooms, i, j, 0);
                }
            }
        }
    }

    public void findDistance(int[][] rooms, int row, int col, int distance) {
        if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length)
            return;

        int curr = rooms[row][col];

        if (curr == -1)
            return;

        /**
         * look for better solution only if distance <= curr cell
         */
        if (distance <= curr) {
            rooms[row][col] = distance;
            findDistance(rooms, row + 1, col, distance + 1);
            findDistance(rooms, row, col + 1, distance + 1);
            findDistance(rooms, row - 1, col, distance + 1);
            findDistance(rooms, row, col - 1, distance + 1);
        } else {
            // if distance already bigger than current cell, no need to keep searching
            return;
        }
    }
}