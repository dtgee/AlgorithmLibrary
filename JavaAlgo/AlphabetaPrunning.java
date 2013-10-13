package JavaAlgo;

public class AlphabetaPrunning {
    // *************************Alpha-Beta Pruning****************************
    // The alpha-beta pruning algorithm, alpha is our best move and beta is the
    // Opponents best move. CITED FROM the TA's white-board drawings
    // (Stellyanos) and
    // Alpha-Beta Prunning's Wikipedia Page.
    public int alphabeta(GameState inState, int depth, int alpha, int beta) {
        // Add code to decide whose turn it is
        boolean isMyTurn = true;

        if (depth == 0 || inState.gameIsOver()) {
            // The getEvaluation is just a method to hold the contents of my
            // evaluation technique. It's lengthy, so thats why its stored in a
            // method.
            return getEvaluation(inState);
        }

        else {
            // If it is our (maximum's) turn.
            /* if it's our (max) turn */
            if (isMyTurn) {
                /* for (all possible moves) */
                {
                    // A clone is needed to keep the game "instance" similar.
                    GameState temp = inState.clone();

                    // Recursively search the new game state
                    int runningMax = alphabeta(temp, depth - 1, alpha, beta);
                    if (runningMax > alpha)
                        alpha = runningMax;

                    // If this is true, we will "prune" off the unneeded
                    // game tree branch.
                    if (beta <= alpha)
                        return alpha;
                }
                return alpha;
            }
            /* if it's opponents (min) turn */
            else {
                /* for (all possible moves) */
                {
                    // A clone is needed to keep the game "instance" similar.
                    GameState temp = inState.clone();
                    // Recursively search the new game state
                    int runningMin = alphabeta(temp, depth - 1, alpha, beta);
                    if (runningMin < beta)
                        beta = runningMin;

                    // Cut-off
                    if (beta <= alpha)
                        return beta;
                }
                return beta;
            }
        }
    }

    // Method designed to provide us with an evaluation of an input game state.
    // This needs to be in a separate method because the evaluation is so
    // lengthy.
    public int getEvaluation(GameState inState) {
        int totalScore = 0, blackScore = 0, whiteScore = 0;
        // Add code to decide whose turn it is
        boolean isMyTurn = true;

        if (isMyTurn)
            totalScore = blackScore - whiteScore;
        else
            totalScore = whiteScore - blackScore;

        return totalScore;
    }
}

interface GameState {
    public GameState getCell(int row, int col);

    public boolean isBlackTurn();

    public boolean gameIsOver();

    public boolean isValidMove(int row, int col);

    public void makeMove(int row, int col);

    public int getBlackScore();

    public int getWhiteScore();

    public GameState clone();
}
