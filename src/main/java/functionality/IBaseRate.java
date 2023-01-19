package functionality;

public interface IBaseRate {
    //write method that returns the base rate
    default double getRate() {
        return 2.5;
    }
}
