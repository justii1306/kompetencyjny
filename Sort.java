import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Sort {

    private final int noErasmus;
    private final int maxErasmus;
    private final LinkedList<Erasmus> erasmus;
    private LinkedList<Erasmus> erasmusToDivide;
    private LinkedList<Mentor> mentors;
    private HashMap<Mentor, LinkedList<Erasmus>> wynik = new HashMap<>();

    public Sort(int noErasmus, int maxErasmus, LinkedList erasmus, LinkedList mentors) {
        this.noErasmus = noErasmus;
        this.maxErasmus = maxErasmus;
        this.erasmus = erasmus;
        this.erasmusToDivide = erasmus;
        this.mentors = mentors;

        if (maxErasmus >= noErasmus){
            this.wynik = Divide();
            System.out.println();
        }

    }

    private HashMap Divide(){
        HashMap<Mentor, LinkedList<Erasmus>> wynik = new HashMap<>();
        int mean = getErasmus().size() / getMentors().size();
        for (int i = 0; i < getMentors().size(); i++) {
            LinkedList<Erasmus> eList = new LinkedList<>();
            Mentor m = getMentors().get(i);
            for (int j = 0; j < mean && j < m.getNumberOfErasmus(); j++) {
                Erasmus e = getErasmus().get(0);
                if (e.getNativeLanguage().equals(m.getLanguage())){
                    eList.add(e);
                    getErasmus().remove(0);
                } else {
                    j--;
                    getErasmus().remove(0);
                    getErasmus().add(e);
                }
            }
            wynik.put(m, eList);
        }
        if (getErasmus().size() > 0){
            for (int i = 0; i < getErasmusToDivide().size(); i++){
                int j = 0;
                Erasmus e = getErasmusToDivide().get(0);
                boolean isAdded = false;
                do {
                    Mentor m = getMentors().get(j);
                    if (e.getNativeLanguage().equals(m.getLanguage())){
                        LinkedList<Erasmus> tempList = wynik.get(m);
                        tempList.add(e);
                        wynik.replace(m, tempList);
                        getErasmus().remove(e);
                        isAdded = true;
                    }
                    j++;
                } while (isAdded == false);
            }
        }
        return wynik;
    }

    public int getNoErasmus() {
        return noErasmus;
    }

    public int getMaxErasmus() {
        return maxErasmus;
    }

    public LinkedList<Erasmus> getErasmus() {
        return erasmus;
    }

    public LinkedList<Mentor> getMentors() {
        return mentors;
    }

    public HashMap<Mentor, LinkedList<Erasmus>> getWynik() {
        return wynik;
    }

    public LinkedList<Erasmus> getErasmusToDivide() {
        return erasmusToDivide;
    }
}
