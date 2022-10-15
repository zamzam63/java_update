package interfaces;

public class Pegasus implements Bird, Horse{

    @Override
    public String speak() {
        return Horse.super.speak() + " " + Bird.super.speak();
    }
}
