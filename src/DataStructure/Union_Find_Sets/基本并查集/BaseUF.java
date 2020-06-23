package DataStructure.Union_Find_Sets.基本并查集;

public abstract class BaseUF {
    public int parents[] = new int[10];
    BaseUF(){
        for (int i = 0; i < 10; i++) {
            parents[i] = i;
        }

    }
    abstract public int find(int v);
    abstract public void union(int v,int p);
    abstract public boolean isSame(int v,int p);
}
