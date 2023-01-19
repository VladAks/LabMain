package com.epam.rd.autotasks.intersection;

public class Line {

    public int k;
    public int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if(this.k == other.k){
            return null;
        }else{
            int x_result = 0;
            int y_result = 0;
            for(int i = -10; i<100; i++){
                if(this.k*i+ this.b == other.k*i+other.b){
                    x_result = i;
                    break;
                }
            }
            y_result = this.k * x_result + this.b;
            Point p = new Point(x_result,y_result);
            return p;
        }
//        throw new UnsupportedOperationException();
    }

}
