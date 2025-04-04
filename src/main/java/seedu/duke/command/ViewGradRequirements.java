package seedu.duke.command;

import static seedu.duke.data.GradModuleList.YEAR1SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR1SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM2MODULES;

import java.util.ArrayList;
import java.util.List;

import seedu.duke.data.Mod;
import seedu.duke.data.User;


public class ViewGradRequirements implements Command {
    private final User user;

    public ViewGradRequirements(User user) {
        this.user = user;
    }

    public void execute() {
        System.out.println("=== Viewing Graduation Requirements ===");
      
        int totalMCs = user.getTotalMCs();

        System.out.println("Current MCs: " + totalMCs);

        if (totalMCs >= 160) {
            System.out.println("You have sufficient MCs to graduate!");
        } else {
            System.out.println("Missing MCs: " + (160 - totalMCs));
        }

        System.out.println("\n=== Modules Missing ===");
        List<Mod> missingModules = getMissingModules();

        if (missingModules.isEmpty()) {
            System.out.println("You have completed all required modules!");
        } else {
            for (Mod m : missingModules) {
                System.out.println("X" + m.getCode() + " - " + m.getName());
            }
        }
    }

    private List<Mod> getMissingModules() {
        List<Mod> allGradModules = new ArrayList<>();
        allGradModules.addAll(YEAR1SEM1MODULES);
        allGradModules.addAll(YEAR1SEM2MODULES);
        allGradModules.addAll(YEAR2SEM1MODULES);
        allGradModules.addAll(YEAR2SEM2MODULES);
        allGradModules.addAll(YEAR3SEM1MODULES);
        allGradModules.addAll(YEAR3SEM2MODULES);
        allGradModules.addAll(YEAR4SEM1MODULES);
        allGradModules.addAll(YEAR4SEM2MODULES);

        List<Mod> missingModules = new ArrayList<>();
        for (Mod m : allGradModules) {
            if (!user.hasModule(m.getCode())) {
                missingModules.add(m);
            }
        }
        return missingModules;
    }
}
