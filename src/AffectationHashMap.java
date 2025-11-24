import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Gestion des affectations Employé -> Département à l'aide d'une HashMap.
 * Un employé ne peut être associé qu'à un seul département à la fois.
 */
public class AffectationHashMap {

    private final Map<Employee, Departement> affectations = new HashMap<>();

    /**
     * Associe un employé à un département. Remplace l'affectation existante le cas échéant.
     */
    public void ajouterEmployeDepartement(Employee employe, Departement departement) {
        if (employe == null || departement == null) {
            System.out.println("Impossible d'affecter : employé ou département nul.");
            return;
        }

        if (affectations.containsKey(employe)) {
            System.out.printf("Mise à jour : %s est désormais affecté au département %s.%n",
                    employe.getNom(), departement.getNom());
        } else {
            System.out.printf("Ajout : %s est affecté au département %s.%n",
                    employe.getNom(), departement.getNom());
        }

        affectations.put(employe, departement);
    }

    /**
     * Affiche les couples employé-département présents dans la map.
     */
    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation à afficher.");
            return;
        }

        affectations.forEach((employe, departement) ->
                System.out.printf("%s -> %s%n", employe, departement));
    }

    /**
     * Supprime un employé quelle que soit son affectation.
     */
    public void supprimerEmploye(Employee employe) {
        if (affectations.remove(employe) != null) {
            System.out.printf("Employé %s supprimé.%n", employe.getNom());
        } else {
            System.out.println("Employé introuvable, rien à supprimer.");
        }
    }

    /**
     * Supprime l'affectation uniquement si l'employé est associé au département ciblé.
     */
    public void supprimerEmployeEtDepartement(Employee employe, Departement departement) {
        if (affectations.containsKey(employe) && departement.equals(affectations.get(employe))) {
            affectations.remove(employe);
            System.out.printf("Affectation de %s au département %s supprimée.%n",
                    employe.getNom(), departement.getNom());
        } else {
            System.out.println("Aucune affectation correspondante à supprimer.");
        }
    }

    /**
     * Affiche la liste des employés présents dans la map.
     */
    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé enregistré.");
            return;
        }
        affectations.keySet().forEach(System.out::println);
    }

    /**
     * Affiche la liste des départements (sans doublons).
     */
    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département enregistré.");
            return;
        }
        Set<Departement> uniques = new HashSet<>(affectations.values());
        uniques.forEach(System.out::println);
    }

    public boolean rechercherEmploye(Employee employe) {
        return affectations.containsKey(employe);
    }

    public boolean rechercherDepartement(Departement departement) {
        return affectations.containsValue(departement);
    }

    /**
     * Retourne une nouvelle TreeMap triée sur l'identifiant de l'employé.
     */
    public TreeMap<Employee, Departement> trierMap() {
        return new TreeMap<>(affectations);
    }
}


