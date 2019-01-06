
import java.util.*;

public class Sort {

    private ArrayList<Erasmus> erasmus;
    private ArrayList<Erasmus> erasmusToDivide;
    private ArrayList<Erasmus> erasmusLeft;
    private ArrayList<Mentor> mentors;
    private ArrayList<Mentor> mentorsToDivade;
    private HashMap<Mentor, ArrayList<Erasmus>> wynik;

    public Sort(int noErasmus, int maxErasmus, ArrayList erasmus, ArrayList mentors) {
        this.erasmus = erasmus;
        this.mentors = mentors;
        this.erasmusToDivide = new ArrayList<>();
        this.mentorsToDivade = new ArrayList<>();
        this.erasmusLeft = new ArrayList<>();
        this.wynik = new HashMap<>();
        HashMap<Mentor, ArrayList<Erasmus>> tempWynik;
        while (getErasmus().size() > 0) {
            getErasmusToDivide().add(getErasmus().remove(0));
            String language = getErasmusToDivide().get(0).getNativeLanguage();
            int erasmusSize = getErasmus().size();
            for (int i = 0; i < erasmusSize; i++) {
                if (getErasmus().get(0).getNativeLanguage().equals(language))
                    getErasmusToDivide().add(getErasmus().remove(0));
                else
                    getErasmus().add(getErasmus().remove(0));
            }
            int mentorSize = getMentors().size();
            for (int i = 0; i < mentorSize; i++) {
                if (getMentors().get(0).getLanguage().equals(language))
                    getMentorsToDivade().add(getMentors().remove(0));
                else
                    getMentors().add(getMentors().remove(0));
            }
            tempWynik = Divide();
            this.wynik.putAll(tempWynik);
            getMentorsToDivade().clear();
        }
        System.out.println();

    }

    private HashMap Divide(){
        HashMap<Mentor, ArrayList<Erasmus>> tempWynik = new HashMap<>();
        int mean;
        try {
            mean = getErasmusToDivide().size() / (getMentorsToDivade().size());
        } catch (ArithmeticException e){
            getErasmusLeft().addAll(getErasmusToDivide());
            getErasmusToDivide().clear();
            return tempWynik;
        }
        for (int i = 0; i < getMentorsToDivade().size(); i++) {
            ArrayList<Erasmus> eList = new ArrayList<>();
            Mentor m = getMentorsToDivade().get(i);
            for (int j = 0; j < mean && j < m.getNumberOfErasmus(); j++) {
                Erasmus e = getErasmusToDivide().remove(0);
                    eList.add(e);
            }
            if (eList.size() > 0) {
                tempWynik.put(m, eList);
            }
        }
        while(getErasmusToDivide().size() > 0) {
            Erasmus e = getErasmusToDivide().remove(0);
            Mentor m = getMentorsToDivade().remove(0);
            if (m.getNumberOfErasmus() > tempWynik.get(m).size()) {
                ArrayList<Erasmus> tempList = tempWynik.get(m);
                tempList.add(e);
                tempWynik.replace(m, tempList);
                getMentorsToDivade().add(m);
            } else {
                getErasmusToDivide().add(0, e);
            }
            if (getMentorsToDivade().size() == 0) {
                getErasmusLeft().addAll(getErasmusToDivide());
                getErasmusToDivide().clear();
            }
        }

        return tempWynik;
    }

    public ArrayList<Erasmus> getErasmus() {
        return erasmus;
    }

    public ArrayList<Erasmus> getErasmusToDivide() {
        return erasmusToDivide;
    }

    public ArrayList<Erasmus> getErasmusLeft() {
        return erasmusLeft;
    }

    public ArrayList<Mentor> getMentors() {
        return mentors;
    }

    public ArrayList<Mentor> getMentorsToDivade() {
        return mentorsToDivade;
    }

    public HashMap<Mentor, ArrayList<Erasmus>> getWynik() {
        return wynik;
    }

    public void setErasmusLeft(ArrayList<Erasmus> erasmusLeft) {
        this.erasmusLeft = erasmusLeft;
    }
}
