public class Character {
    char name;
    int count;

    public Character(char name, int count) {
        this.name = name;
        this.count = count;
    }

    public void show(){
        System.out.println(name+ " : "+count);
    }

    public char getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
