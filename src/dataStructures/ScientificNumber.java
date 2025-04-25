package dataStructures;

public class ScientificNumber {
    private double number;
    private int notation;

    public ScientificNumber(double number, int notation){
        this.number = number;
        this.notation = notation;
    }

    public double getNumber() {
        return number;
    }

    public int getNotation() {
        return notation;
    }

    public void example(ScientificNumber num) {
        this.add(num).add(num).add(num);
    }

    //Write a method to validate the scientific notation, if the number is not in scientific notation, put it in scientific notation
    public ScientificNumber check(){
        if((int)number==0) return this;
        if (this.number/10>1){
            number = number/10;
            notation = notation+1;
            check();
        }else if (number*10<1){
            number = number*10;
            notation-=1;
            check();
        }
        return this;
    }

    //Write a method to add another scientific number to this one
    public ScientificNumber add(ScientificNumber other) {
        int exponentDiff = Math.abs(notation - other.getNotation());
        if(exponentDiff > 4) {
            if (this.notation <= other.getNotation()) {
                this.number = other.number;
                this.notation = other.notation;
            }
        } else {
            number += other.getNumber()*(Math.pow(10, other.getNotation()-notation));
        }
        return this;
    }

    //Write a method to subtract another scientific number from this one
    public ScientificNumber subtract(ScientificNumber other) {
        ScientificNumber temp = new ScientificNumber(-other.number,other.getNotation());
        return add(temp);
    }

    //Write am method to multiply another scientific number to this one
    public ScientificNumber multiply(ScientificNumber other){
        number *=other.getNumber();
        notation +=other.getNotation();
        return check();
    }
    //a * 10^b * c * 10^d
    //(a * c) * (10^b * 10^d) = (a * c) * 10^(b+d)

    //Write a method to divide this scientific number by another one
    public ScientificNumber division(ScientificNumber other){
        number = number/other.getNumber();
        notation-=other.getNotation();
        return check();
    }

    @Override
    public String toString(){
        return number+"x10^"+notation;
    }
}