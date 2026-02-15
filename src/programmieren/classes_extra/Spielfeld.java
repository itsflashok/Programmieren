package programmieren.classes_extra;

public class Spielfeld {
    private int numColors;
    private int[][] board;
    private int size;

    public Spielfeld(int size, int numColors) {
        this.size = size;
        this.numColors = numColors;
        this.board = new int[size][size];
        this.initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                int color;
                do {
                    color = (int) (Math.random() * this.numColors);
                } while (this.formsTriple(i, j, color));

                this.board[i][j] = color;
            }
        }
    }

    public boolean formsTriple(int row, int col, int color) {
        if (col >= 2 &&
                this.board[row][col - 1] == color &&
                this.board[row][col - 2] == color) {
            return true;
        }

        if (col >= 1 && col < this.size - 1 &&
                this.board[row][col - 1] == color &&
                this.board[row][col + 1] == color) {
            return true;
        }

        if (col < this.size - 2 &&
                this.board[row][col + 1] == color &&
                this.board[row][col + 2] == color) {
            return true;
        }

        if (row >= 2 &&
                this.board[row - 1][col] == color &&
                this.board[row - 2][col] == color) {
            return true;
        }

        if (row >= 1 && row < this.size - 1 &&
                this.board[row - 1][col] == color &&
                this.board[row + 1][col] == color) {
            return true;
        }

        if (row < this.size - 2 &&
                this.board[row + 1][col] == color &&
                this.board[row + 2][col] == color) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (int j = 0; j < this.size; j++) {
            sb.append((char) ('A' + j)).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < this.board.length; i++) {
            sb.append(String.format("%2d ", i + 1));
            for (int j = 0; j < this.board[i].length; j++) {
                sb.append(this.board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int getColor(int row, int col) {
        return this.board[row][col];
    }

    public void setColor(int row, int col, int color) {
        if (color >= 0 && color < this.numColors) {
            this.board[row][col] = color;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getNumColors() {
        return this.numColors;
    }

    public void changeColors(int row1, int col1, int row2, int col2) {
        int temp = this.board[row1][col1];
        this.board[row1][col1] = this.board[row2][col2];
        this.board[row2][col2] = temp;
    }

    public int detectAndMarkMatches() {
        boolean[][] marked = new boolean[this.size][this.size];
        int totalMarked = 0;

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size - 2; col++) {
                int color = this.board[row][col];
                if (color == -1)
                    continue;

                int count = 1;
                while (col + count < this.size && this.board[row][col + count] == color) {
                    count++;
                }

                if (count >= 3) {
                    for (int i = 0; i < count; i++) {
                        marked[row][col + i] = true;
                    }
                }
            }
        }

        for (int col = 0; col < this.size; col++) {
            for (int row = 0; row < this.size - 2; row++) {
                int color = this.board[row][col];
                if (color == -1)
                    continue;

                int count = 1;
                while (row + count < this.size && this.board[row + count][col] == color) {
                    count++;
                }

                if (count >= 3) {
                    for (int i = 0; i < count; i++) {
                        marked[row + i][col] = true;
                    }
                }
            }
        }

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (marked[row][col]) {
                    this.board[row][col] = -1;
                    totalMarked++;
                }
            }
        }

        return totalMarked;
    }

    public int calculateScore() {
        int totalScore = 0;

        for (int row = 0; row < this.size; row++) {
            int count = 0;
            for (int col = 0; col < this.size; col++) {
                if (this.board[row][col] == -1) {
                    count++;
                } else {
                    if (count >= 3) {
                        totalScore += calculateMatchScore(count);
                    }
                    count = 0;
                }
            }
            if (count >= 3) {
                totalScore += calculateMatchScore(count);
            }
        }

        for (int col = 0; col < this.size; col++) {
            int count = 0;
            for (int row = 0; row < this.size; row++) {
                if (this.board[row][col] == -1) {
                    count++;
                } else {
                    if (count >= 3) {
                        totalScore += calculateMatchScore(count);
                    }
                    count = 0;
                }
            }
            if (count >= 3) {
                totalScore += calculateMatchScore(count);
            }
        }

        return totalScore / 2;
    }

    private int calculateMatchScore(int matchLength) {
        if (matchLength == 3)
            return 30;
        if (matchLength == 4)
            return 40;
        if (matchLength >= 5)
            return 50;
        return 0;
    }

    public void dropAndRefill() {
        for (int col = 0; col < this.size; col++) {
            int writeRow = this.size - 1;
            for (int readRow = this.size - 1; readRow >= 0; readRow--) {
                if (this.board[readRow][col] != -1) {
                    this.board[writeRow][col] = this.board[readRow][col];
                    if (writeRow != readRow) {
                        this.board[readRow][col] = -1;
                    }
                    writeRow--;
                }
            }
        }

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.board[row][col] == -1) {
                    int color;
                    do {
                        color = (int) (Math.random() * this.numColors);
                    } while (this.formsTriple(row, col, color));
                    this.board[row][col] = color;
                }
            }
        }
    }

}