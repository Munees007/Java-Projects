package helper;

public class DataViewer<T> {
    T[] data;

    public DataViewer(T[] data)
    {
        this.data = data;
    }

    public void print()
    {
        for(T m : data)
        {
            System.out.println(m);
        }
    }
}
