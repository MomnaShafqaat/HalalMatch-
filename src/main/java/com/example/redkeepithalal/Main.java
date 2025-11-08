package com.example.redkeepithalal;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.lang.String ;
public class Main {/*It creates a Scanner object to read input from the user.
    It initializes an ArrayList of userInfo objects called data to store the personal information and preferences of each person.
    It calls the inputUserData function to get the personal information and preferences of the current user.
    It calls the inputDataFromFile function to read the personal information and preferences of other people
    from a file and store them in the data ArrayList.
    It creates an ArrayList of match objects called matches to store the potential matches for the current user.
    It calls the matching function to compare the current user's preferences with the personal information and preferences of the other people
     in the data ArrayList and add the matches to the matches ArrayList.
    It displays the personal information of the person with whom the current user has the highest match percentage.
    It then allows the current user to approve or reject the displayed match. The current user can skip the displayed match by entering 1,
     approve the match by entering 2, or exit the program by entering 0.
    If the current user skips a match, the program displays the next potential match.
    If the current user approves the match, the match object in the matches ArrayList is updated to reflect the approval.
    If there are no more potential ma*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //array list to input data from file
        ArrayList<userInfo> data = new ArrayList<>();
        // return userInfo object which contains users details
        userInfo user = inputUserData() ;//user data
        //function called below adds data from the file
        inputDataFromFile(data);//preference data in file
        //array list of people the user will be matched with
        ArrayList<match> matches = new ArrayList<>();
        //function that compares user preferences with data of people in file
        matching(user, data, matches);
        //displays the person info with which
        user.setMatches(matches);
        displayPartnerInfo(partnerWithHighestPercentage(matches));
        int choice = 1 ;
        int num = user.getMatches().size() - 2; //remaining potential partners that arent displayed
        while (choice != 0 && choice != 2 && num >= 0) {
            System.out.println("Enter 1 to skip,2 to approve and 0 to exit : ");
            choice = input.nextInt() ;
            if(choice == 1)
            {
                user.getMatches().get(user.getMatches().size() - 1).setApproved(false);
                displayPartnerInfo(user.getMatches().get(num).getPotentialMatch());
                num--;
            }
        }
        if(choice == 2)
            user.getMatches().get(user.getMatches().size() - 1).setApproved(true);
        if (num < 0)
            System.out.println("No other match check in later!");
    }
    public static ArrayList<match> searchByLocation(location searchLocation,ArrayList<userInfo> data,userInfo user)
    {
        ArrayList<match> userWithSameLocation = new ArrayList<>() ;
        int j = 0 ;
        for(int i=0 ; i<data.size() ; i++)
        {
            if(user.getGender() != data.get(i).getGender())
            {
                if(searchLocation.getCountry().equals(data.get(i).getUserLocation().getCountry()) && searchLocation.getCity().equals(data.get(i).getUserLocation().getCity()))
                {
                    userWithSameLocation.add(j,new match()) ;
                    userWithSameLocation.get(j).setPotentialMatch(data.get(i));
                    j++ ;
                }
            }
        }
        return userWithSameLocation ;
    }

    public static void inputDataFromFile(ArrayList<userInfo> data) {
        // variable to pass values to constructor
        String name, familyType, qualification, company, country, city, maritalStatus, religion, location;
        int age, height, yearsOfEducation, numOfMembers, income;
        long number;
        char gender, hafiz, work;
        boolean famTakeCare, secMarriage, furtherWork, canCook, cookPreference, isWorking;
        String[] interests = new String[3];
        //input data of candidates from file
        try {//FileInputStream object reads the raw data from the file,
            // while the DataInputStream object interprets this data in a specific format.
            FileInputStream inputFromFile = new FileInputStream("D:\\rishtaData.txt") ;
            DataInputStream candidates = new DataInputStream(inputFromFile) ;
            Scanner input = new Scanner(candidates);
            int x = 0;//x is used to keep track of the index of the current userInfo
            while (input.hasNextLine()) {
                if (x > 0)
                    input.nextLine();
                name = input.nextLine();
                age = input.nextInt();
                height = input.nextInt();
                hafiz = input.next().charAt(0);
                yearsOfEducation = input.nextInt();
                numOfMembers = input.nextInt();
                input.nextLine();
                familyType = input.nextLine();
                isWorking = input.nextBoolean();
                if (isWorking) {
                    input.nextLine();
                    qualification = input.nextLine();
                    company = input.nextLine();
                    income = input.nextInt();
                } else {
                    qualification = "";
                    company = "";
                    income = 0;
                }
                input.nextLine();
                country = input.nextLine();
                city = input.nextLine();
                gender = input.next().charAt(0);
                input.nextLine();
                maritalStatus = input.nextLine();
                religion = input.nextLine();
                number = input.nextLong();
                input.nextLine();
                for (int i = 0; i < 3; i++) {
                    interests[i] = input.nextLine() ;
                }
                data.add(new userInfo(name, age, height, hafiz, yearsOfEducation, new family(numOfMembers, familyType), isWorking, new sourceOfIncome(qualification, company), income, new location(country, city), gender, maritalStatus, religion, number,interests));
                hafiz = input.next().charAt(0);
                input.nextLine();
                location = input.nextLine();
                income = input.nextInt();
                yearsOfEducation = input.nextInt();
                input.nextLine();
                qualification = input.nextLine();
                numOfMembers = input.nextInt();
                famTakeCare = input.nextBoolean();
                secMarriage = input.nextBoolean();
                furtherWork = input.nextBoolean();
                canCook = input.nextBoolean();
                cookPreference = input.nextBoolean();
                data.get(x).setPreferences(new userPreference(hafiz, location, income, yearsOfEducation, qualification, numOfMembers, new qna(famTakeCare, secMarriage, furtherWork,canCook, cookPreference)));
                x++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static userInfo inputUserData()
    {
        String name, familyType, qualification, company, country, city, maritalStatus, religion, location;
        int age, height, yearsOfEducation, numOfMembers, income;
        long number;
        char gender, hafiz, work;
        boolean isWorking;
        String[] interests = new String[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        name = input.nextLine();
        System.out.print("Enter age : ");
        age = input.nextInt();
        System.out.print("Enter height (in cm) : ");
        height = input.nextInt();
        System.out.print("Enter y if Hafiz and n if not : ");
        hafiz = input.next().charAt(0);
        System.out.print("Enter your years of education (12 for fsc , 16 for bachelors and 18 for masters and 19 for phd ) : ");
        yearsOfEducation = input.nextInt();
        System.out.print("Enter total number of family members : ");
        numOfMembers = input.nextInt();
        System.out.print("enter family system (nuclear or joint) : ");
        input.nextLine();
        familyType = input.nextLine();
        System.out.print("Enter y if you work and n if you dont earn : ");
        work = input.next().charAt(0);
        if (work == 'y') {
            isWorking = true;
            System.out.print("Enter your qualification (software engineer etc) : ");
            input.nextLine();
            qualification = input.nextLine();
            System.out.print("Enter your company or institute : ");
            company = input.nextLine();
            System.out.print("Enter your income roughly : ");
            income = input.nextInt();
        } else if (work == 'n') {
            isWorking = false;
            qualification = "";
            company = "";
            income = 0;
        } else {
            isWorking = false;
            qualification = "";
            company = "";
            income = 0;
        }
        System.out.print("Enter your country : ");
        input.nextLine();
        country = input.nextLine();
        System.out.print("Enter your city : ");
        city = input.nextLine();
        System.out.print("Enter your gender(f for female and m for male ) : ");
        gender = input.next().charAt(0);
        System.out.print("Enter your maritalStatus (single or married ,previously married ): ");
        input.nextLine();
        maritalStatus = input.nextLine();
        System.out.print("Enter your religion : ");
        religion = input.nextLine();
        System.out.print("Enter your phone number : ");
        number = input.nextLong();
        System.out.print("Enter any 3 of your interests or hobbies ");
        input.nextLine();
        for (int i = 0; i < 3; i++) {
            interests[i] = input.nextLine() ;
        }
        userInfo user = new userInfo(name, age, height, hafiz, yearsOfEducation, new family(numOfMembers, familyType), isWorking, new sourceOfIncome(qualification, company), income, new location(country, city), gender, maritalStatus, religion, number,interests);
        //input user preference
        System.out.print("Enter preference for hafiz, y for hafiz n for not or doesnt matter ");
        hafiz = input.next().charAt(0);
        System.out.println("Enter preferred location");
        System.out.print("n for near me and d for does not matter : ");
        input.nextLine();
        location = input.nextLine();
        System.out.print("Enter preferred income if working partner is wanted else Enter 0 : ");
        income = input.nextInt();
        if (income != 0) {
            System.out.print("Enter preferred qualification if any else enter n : ");
            input.nextLine();
            qualification = input.nextLine();
        } else
            qualification = "";
        System.out.print("Enter preferred years of education : ");
        yearsOfEducation = input.nextInt();
        System.out.print("Enter preferred family members (99 if it does not matter) : ");
        numOfMembers = input.nextInt();
        user.setPreferences(new userPreference(hafiz, location, income, yearsOfEducation, qualification, numOfMembers));
        System.out.println("Please answer the following questions for us to find a better potential match for you! ");
        System.out.println("Enter 1 for yes, 0 for no ");
        System.out.print("Can you cook ? ");


            if (input.nextInt() == 0)
                user.getPreferences().getQuestionsAndAnswers().setCanCook(false);
            else
                user.getPreferences().getQuestionsAndAnswers().setCanCook(true);
            System.out.print("Would you prefer that your partner cooks ? ");
            if (input.nextInt() == 0)
                user.getPreferences().getQuestionsAndAnswers().setCookPreference(false);
            else
                user.getPreferences().getQuestionsAndAnswers().setCookPreference(true);
            if (user.getGender() == 'm' || user.getGender() == 'M')
                System.out.print("Would you allow your partner to pursue further education or to work ?");
            else
                System.out.print("Do you want to pursue further education or work ? ");
            if (input.nextInt() == 0)
                user.getPreferences().getQuestionsAndAnswers().setFurtherStudiesOrWork(false);
            else
                user.getPreferences().getQuestionsAndAnswers().setFurtherStudiesOrWork(true);
            if (user.getGender() == 'm' || user.getGender() == 'M')
                System.out.print("Do you expect your partner to take care of your family ?");
            else
                System.out.print("Would you want to take care of your partners family ? ");
            if (input.nextInt() == 0)
                user.getPreferences().getQuestionsAndAnswers().setTakeCareOfFamily(false);
            else
                user.getPreferences().getQuestionsAndAnswers().setTakeCareOfFamily(true);
            if (user.getGender() == 'm' || user.getGender() == 'M')
                System.out.print("Would you marry twice if gotten the chance ?");
            else
                System.out.print("Would you allow your partner to marry twice ? ");
            if (input.nextInt() == 0)
                user.getPreferences().getQuestionsAndAnswers().setSecondMarriage(false);
            else
                user.getPreferences().getQuestionsAndAnswers().setSecondMarriage(false);
            return user;
    }
    public static void writeInFile(userInfo user)
    {
        try{
            FileWriter file = new FileWriter("D:\\rishtaData.txt",true) ;
            Formatter outputInFile = new Formatter(file) ;
            outputInFile.format("\n") ;
            outputInFile.format("%s\n" ,user.getName()) ;
            outputInFile.format("%d\n" ,user.getAge()) ;
            outputInFile.format("%d\n" ,user.getHeight()) ;
            outputInFile.format("%s\n" , user.getHafiz()) ;
            outputInFile.format("%d\n" , user.getYearsOfEducation()) ;
            outputInFile.format("%d\n" , user.getFamilyInfo().getNumOfFamilyMembers()) ;
            outputInFile.format("%s\n" , user.getFamilyInfo().getFamilySystem()) ;
            outputInFile.format("%b\n" , user.isWorking()) ;
            if(user.isWorking())
            {
                outputInFile.format("%s\n" , user.getIncomeInfo().getQualification()) ;
                outputInFile.format("%s\n" , user.getIncomeInfo().getCompany()) ;
                outputInFile.format("%d\n" , user.getIncome()) ;
            }
            outputInFile.format("%s\n" , user.getUserLocation().getCountry()) ;
            outputInFile.format("%s\n" , user.getUserLocation().getCity()) ;
            outputInFile.format("%s\n" , user.getGender()) ;
            outputInFile.format("%s\n" , user.getMaritalStatus()) ;
            outputInFile.format("%s\n" , user.getReligion()) ;
            outputInFile.format("%d\n" , user.getNumber()) ;
            outputInFile.format("%s\n" , user.getHobbies()[0]) ;
            outputInFile.format("%s\n" , user.getHobbies()[1]) ;
            outputInFile.format("%s\n" , user.getHobbies()[2]) ;
            outputInFile.format("%s\n" , user.getPreferences().getHafiz()) ;
            outputInFile.format("%s\n" , user.getPreferences().getLocation()) ;
            outputInFile.format("%s\n" , user.getPreferences().getIncome()) ;
            outputInFile.format("%d\n" , user.getPreferences().getYearsOfEducation()) ;
            outputInFile.format("%s\n" , user.getPreferences().getQualification()) ;
            outputInFile.format("%s\n" , user.getPreferences().getFamilyMembers()) ;
            outputInFile.format("%b\n" , user.getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily()) ;
            outputInFile.format("%b\n" , user.getPreferences().getQuestionsAndAnswers().isSecondMarriage()) ;
            outputInFile.format("%b\n" , user.getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork()) ;
            outputInFile.format("%b\n" , user.getPreferences().getQuestionsAndAnswers().isCanCook()) ;
            outputInFile.format("%b" , user.getPreferences().getQuestionsAndAnswers().isCookPreference()) ;
            outputInFile.close() ;
        }catch(IOException ex)
        {
            System.out.println("Error in opening output file");
        }

    }

    public static void displayPartnerInfo(userInfo partner) {
        System.out.println("Name : " + partner.getName());
        System.out.println("Age : " + partner.getAge());
        System.out.println("Height : " + partner.getHeight());
        System.out.println("Years of education : " + partner.getYearsOfEducation());
        System.out.print("Hafiz status : ");
        if (partner.getHafiz() == 'y')
            System.out.println("yes!");
        else
            System.out.println("no!");
        if (partner.isWorking()) {
            System.out.println("Qualification : " + partner.getIncomeInfo().getQualification());
            System.out.println("Company : " + partner.getIncomeInfo().getCompany());
            System.out.println("Income : " + partner.getIncome());
        } else
            System.out.println("Not employed");
        System.out.println("Location information : ");
        System.out.println("Country : " + partner.getUserLocation().getCountry());
        System.out.println("City : " + partner.getUserLocation().getCity());
        System.out.println("Contact Information : " + partner.getNumber());
        System.out.println("Interests : ");
        for (int i = 0; i < 3; i++) {
            System.out.println(partner.getHobbies()[i]);
        }
        if (partner.getPreferences().getQuestionsAndAnswers().isCanCook())
            System.out.println("Can cook");
        else
            System.out.println("Can not cook");
        if (partner.getPreferences().getQuestionsAndAnswers().isCookPreference())
            System.out.println("Expects you to cook ");
        else
            System.out.println("Does not expect you to cook ");
        if (partner.getPreferences().getQuestionsAndAnswers().isSecondMarriage())
            System.out.println("Ok with marrying twice");
        else
            System.out.println("Not ok with marrying twice");
        if (partner.getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily())
            System.out.println("Prefer you to take care of their family");
        else
            System.out.println("Does not expect from you to take care of their family");
        if (partner.getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork() && partner.getGender() == 'f')
            System.out.println("Wants to pursue further studies and work");
        else if (!partner.getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork() && partner.getGender() == 'f')
            System.out.println("Does not want to pursue further studies or work ");
        else if (partner.getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork() && partner.getGender() == 'm')
            System.out.println("Further studies or work is encouraged ");
        else
            System.out.println("Further studies or work is not encouraged ");

    }

    public static userInfo partnerWithHighestPercentage(ArrayList<match> matches) {
        //sort arraylist here matchungs with highest counter
        match temp;
        int index;//index 0 hai
        for (int i = 1; i < matches.size(); i++) {
            index = i - 1;
            while (index >= 0) {
                if (matches.get(i).getCounter() < matches.get(index).getCounter()) {
                        temp = matches.get(i);
                        matches.set(i, matches.get(index));
                        matches.set(index, temp);
                        i = index;
                        index = i - 1;
                } else
                    index--;
            }
        }
        temp = matches.get(matches.size()-1); //last element with largest counter value is returned
        return temp.getPotentialMatch();
    }

    public static void matching(userInfo user, ArrayList<userInfo> data, ArrayList<match> matches) {
        int j = 0;
        for(int i = 0; i < data.size(); i++) {
            //gender should be opposite
            if (user.getGender() != data.get(i).getGender()) {
                //if religion is not same then comparing will not further proceed
                if (user.getReligion().equals(data.get(i).getReligion())) {
                    //condition where if age gap is greater than 10 than further comparing will not proceed
                    if (( user.getGender() == 'f' && (data.get(i).getAge() - user.getAge() < 10) && (data.get(i).getAge() - user.getAge() > -3)) || (user.getGender() == 'm' && (user.getAge() - data.get(i).getAge() < 10) && (user.getAge() - data.get(i).getAge() > -3))) {
                        //comparing proceeds only if both have the same preference for location or if either opted for near me option and both do have the same location
                        if ((user.getPreferences().getLocation().equals("does not matter") && data.get(i).getPreferences().getLocation().equals("does not matter")) || (((user.getPreferences().getLocation().equals("near me") && data.get(i).getPreferences().getLocation().equals("near me")) || !(user.getPreferences().getLocation().equals(data.get(i).getPreferences().getLocation()))) && (user.getUserLocation().getCountry().equals(data.get(i).getUserLocation().getCountry()) && user.getUserLocation().getCity().equals(data.get(i).getUserLocation().getCity())))) {
                            //potential match created
                            matches.add(new match());
                            //user preferences are compared with data of potential match
                            matches.get(j).setPotentialMatch(data.get(i));
                            if (user.getGender() == 'f') {
                                if (data.get(i).getAge() > user.getAge() && data.get(i).getAge() < (user.getAge() + 7))
                                    matches.get(j).incrementCounter();
                                if (data.get(i).getAge() > user.getAge() && data.get(i).getAge() < (user.getAge() + 5))
                                    matches.get(j).incrementCounter();
                                if (user.getHeight() <= data.get(i).getHeight())
                                    matches.get(j).incrementCounter();
                            } else //user is a male
                            {
                                if (data.get(i).getAge() < user.getAge() && data.get(i).getAge() > (user.getAge() - 7))
                                    matches.get(j).incrementCounter();
                                if (data.get(i).getAge() < user.getAge() && data.get(i).getAge() > (user.getAge() - 5))
                                    matches.get(j).incrementCounter();
                                if (user.getHeight() >= data.get(i).getHeight())
                                    matches.get(j).incrementCounter();
                            }
                            if (user.getPreferences().getYearsOfEducation() >= data.get(i).getYearsOfEducation())
                                matches.get(j).incrementCounter();
                            if (user.getPreferences().getIncome() == 0 && !data.get(i).isWorking())
                            {
                                //increment for qualification and income preference
                                matches.get(j).incrementCounter();
                                matches.get(j).incrementCounter();
                            }
                            else if (data.get(i).getIncome() >= user.getPreferences().getIncome()) {
                                matches.get(j).incrementCounter();
                                if (user.getPreferences().getQualification().equals(data.get(i).getIncomeInfo().getQualification()))
                                    matches.get(j).incrementCounter();
                            }
                            if (user.getPreferences().getFamilyMembers() == 0)
                                matches.get(j).incrementCounter();
                            else if (user.getPreferences().getFamilyMembers() <= data.get(i).getFamilyInfo().getNumOfFamilyMembers())
                                matches.get(j).incrementCounter();
                            //comparing boolean values and their interest
                            if (user.getPreferences().getQuestionsAndAnswers().isCanCook() == data.get(i).getPreferences().getQuestionsAndAnswers().isCookPreference())
                                matches.get(j).incrementCounter();
                            if (user.getPreferences().getQuestionsAndAnswers().isCookPreference() == data.get(i).getPreferences().getQuestionsAndAnswers().isCanCook())
                                matches.get(j).incrementCounter();
                            if (user.getPreferences().getQuestionsAndAnswers().isSecondMarriage() == data.get(i).getPreferences().getQuestionsAndAnswers().isSecondMarriage())
                                matches.get(j).incrementCounter();
                            if (user.getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork() == data.get(i).getPreferences().getQuestionsAndAnswers().isFurtherStudiesOrWork())
                                matches.get(j).incrementCounter();
                            if (user.getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily() == data.get(i).getPreferences().getQuestionsAndAnswers().isTakeCareOfFamily())
                                matches.get(j).incrementCounter();
                            for (int x = 0; x < 3; x++) {
                                for (int y = 0; y < 3; y++) {
                                    if (user.getHobbies()[x].equals(data.get(i).getHobbies()[y]))
                                        matches.get(j).incrementCounter();
                                }
                            }
                            //potential match's preferences are compared with user profile
                            if (data.get(i).getPreferences().getYearsOfEducation() >= user.getYearsOfEducation())
                                matches.get(j).incrementCounter();
                            if (data.get(i).getPreferences().getIncome() == 0 && !user.isWorking())
                                matches.get(j).incrementCounter();
                            else if (user.getIncome() >= data.get(i).getPreferences().getIncome()) {
                                matches.get(j).incrementCounter();
                                if (data.get(i).getPreferences().getQualification().equals(user.getIncomeInfo().getQualification()))
                                    matches.get(j).incrementCounter();
                            }
                            if (data.get(i).getPreferences().getFamilyMembers() <= user.getFamilyInfo().getNumOfFamilyMembers())
                                matches.get(j).incrementCounter();
                            else if (data.get(i).getPreferences().getFamilyMembers() == 0)
                                matches.get(j).incrementCounter();
                            j++;
                        }
                    }
                }
            }
        }
    }
}