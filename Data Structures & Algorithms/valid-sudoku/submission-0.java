class Solution {
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Set<String> s = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                char ch = board[i][j];

                if(ch != '.') {

                    String row = "r" + i + ch;

                    if(s.contains(row)) {
                        return false;
                    }

                    s.add(row);

                    String col = "c" + j + ch;

                    if(s.contains(col)) {
                        return false;
                    }

                    s.add(col);

                    String box = "b" + (i/3) + "-" + (j/3) + ch;

                    if(s.contains(box)) {
                        return false;
                    }

                    s.add(box);
                }
            }
        }

        return true;
    }
}