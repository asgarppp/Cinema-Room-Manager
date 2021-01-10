class Application {

    String name;
    
    void run(String[] args) {
        System.out.println(this.name);
        for (String strTemp : args) {
            System.out.println(strTemp);
        }
    }
}
