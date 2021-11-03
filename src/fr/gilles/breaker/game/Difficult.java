package fr.gilles.breaker.game;

public enum Difficult {
    EASY(7),
    MEDIUM(5),
    HARD(1);

    private  int difficult;

    Difficult(int difficult){
        this.difficult = difficult;
    }

    public int getDifficult() {
        return difficult;
    }
}
