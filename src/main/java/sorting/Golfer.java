package sorting;

import java.util.Objects;

public class Golfer implements Comparable<Golfer> {



    private String first;
    private String last;
    private int score;

    public Golfer(){}

    public Golfer(String first, String last, int score) {
        this.first = first;
        this.last = last;
        this.score = score;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Golfer o) {
        return score - o.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Golfer golfer = (Golfer) o;
        return score == golfer.score && Objects.equals(first, golfer.first) && Objects.equals(last, golfer.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, score);
    }

    @Override
    public String toString() {
        return "Golfer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", score=" + score +
                '}';
    }
}
