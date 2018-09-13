package Main;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class WarehouseMovement implements Serializable{

    protected GregorianCalendar data;
    protected int ID;
    
    //GET - DATA
    public GregorianCalendar getData() {
        return data;
    }

    public String getDataInString() {
        return "" + data.get(GregorianCalendar.DATE) + "/" + data.get(GregorianCalendar.MONTH) + "/" + data.get(GregorianCalendar.YEAR);
    }

    public String getDay() {
        return "" + data.get(GregorianCalendar.DATE);
    }

    public String getMonth() {
        return "" + data.get(GregorianCalendar.MONTH);
    }

    public String getYear() {
        return "" + data.get(GregorianCalendar.YEAR);
    }

    //SET DATA
    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public void setData() {
        this.data = new GregorianCalendar();
    }

    public void setData(int day, int month, int year) {
        this.data = new GregorianCalendar(year, month, day);
    }
    
    public void setDay(int day){
        data.set(day, GregorianCalendar.DATE);
    }
    
    public void setMonth(int month){
        data.set(month, GregorianCalendar.MONTH);
    }
    
    public void setYear(int year){
        this.data.set(year, GregorianCalendar.YEAR);
    }

    public int getID() {
        return ID;
    }

    public String getIDtoString() {
        return "" + hashCode();
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();

}
