package ca.macewan.cmpt305lab;

public class Neighbourhood {

    private int neighbourhoodId;
    String neighbourhoodName;

    public Neighbourhood(int id, String neighbourhoodName) {
        this.neighbourhoodId = id;
        this.neighbourhoodName = neighbourhoodName;
    }
    public void getNeighbourhoodId(){
        this.neighbourhoodId = this.neighbourhoodId;
    }
    public void setNeighbourhoodId(int neighbourhoodId) {
        this.neighbourhoodId = neighbourhoodId;
    }

    public void setNeighbourhoodName(String neighbourhoodName) {
        this.neighbourhoodName = neighbourhoodName;
    }

    public void getNeighbourhoodName(){
        this.neighbourhoodName=neighbourhoodName;
    }




}
