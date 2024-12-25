public class Main {
    public static void main(String[] args) {
        List<String> developerSkills = new ArrayList<>();
        developerSkills.add("Java");
        developerSkills.add("Python");

        TeamMember developer = TeamMemberFactory.createMember("Developer", "Іван", 5, developerSkills);
        TeamMember tester = TeamMemberFactory.createMember("Tester", "Марія", 3, new ArrayList<>(List.of("Manual", "Automation")));
        TeamMember projectManager = TeamMemberFactory.createMember("ProjectManager", "Олексій", 7, new ArrayList<>(List.of("10")));

        Project project = new Project();

        Observer developerObserver = new TeamMemberObserver(developer.name);
        Observer testerObserver = new TeamMemberObserver(tester.name);
        Observer pmObserver = new TeamMemberObserver(projectManager.name);

        project.addObserver(developerObserver);
        project.addObserver(testerObserver);
        project.addObserver(pmObserver);

        project.addTeamMember(developer);
        project.addTeamMember(tester);
        project.addTeamMember(projectManager);

        project.addTask(new DevelopmentTask("Розробити функцію авторизації"));
        project.addTask(new TestingTask("Протестувати функцію авторизації"));

        project.executeTasks();
    }
}
