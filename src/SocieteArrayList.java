import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employee> {
    private ArrayList<Employee> employes;

    public SocieteArrayList() {
        this.employes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employee t) {
        employes.add(t);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employee emp : employes) {
            if (emp.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employee t) {
        return employes.contains(t);
    }

    @Override
    public void supprimerEmploye(Employee t) {
        employes.remove(t);
    }

    @Override
    public void displayEmploye() {
        for (Employee emp : employes) {
            System.out.println(emp);
        }
    }

    @Override
    public void trierEmployeParId() {
        // Utilisation de Comparable
        Collections.sort(employes);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        // Utilisation de Comparator
        Collections.sort(employes, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // D'abord par nom de département
                int compareDepartement = e1.getNomDepartement().compareTo(e2.getNomDepartement());
                if (compareDepartement != 0) {
                    return compareDepartement;
                }
                // Ensuite par grade (ordre décroissant)
                return Integer.compare(e2.getGrade(), e1.getGrade());
            }
        });
    }

    public ArrayList<Employee> getEmployes() {
        return employes;
    }
}

