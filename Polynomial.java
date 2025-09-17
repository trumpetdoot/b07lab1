import java.lang.Math;

public class Polynomial {
    double coefficient[];

    public Polynomial() {
        coefficient = new double[1];
    }
    public Polynomial(double arr[]){
        coefficient = arr;
    }
    public Polynomial add(Polynomial poly) {
        int n = coefficient.length, m = poly.coefficient.length;
        double sum[] = new double[Math.max(n, m)];
        for(int i=0; i<Math.min(n, m); i++){
            sum[i] = coefficient[i] + poly.coefficient[i];
        }
        if(n > m){
            for(int i=m; i<n; i++) sum[i] += coefficient[i];
        } else {
            for(int i=n; i<m; i++) sum[i] += poly.coefficient[i];
        }
        return new Polynomial(sum);
    }

    public double evaluate(double in){
        double res = 0; 
        for(int i=0; i<coefficient.length; i++){
            res += Math.pow(in, i) * coefficient[i];
        }
        return res;
    }
    public boolean hasRoot(double in){
        if(evaluate(in) == 0) return true;
        else return false;
    }
}