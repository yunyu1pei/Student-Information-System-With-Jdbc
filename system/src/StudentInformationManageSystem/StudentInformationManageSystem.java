package StudentInformationManageSystem;


import java.util.Scanner;

public class StudentInformationManageSystem {
    public static void main(String[] args) {

        System.out.println("-------------欢迎来到学生信息管理系统---------");
        StudentMain.studentmains();
        while (true){
            Scanner input = new Scanner(System.in);
            int scan = input.nextInt();
            switch (scan){
                case 1:
                    StudentAdd.add();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 2:
                    StudentQuery.query();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 3:
                    StudentUpdate.update();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 4:
                    StudentDelete.delete();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 5:
                    StudentClass.stuclass();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 6:
                    StudentCourse.course();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 7:
                    StudentScore.score();
                    System.out.println("-----------------------");
                    StudentMain.studentmains();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("无效的输入！");
                    System.exit(0);
            }
        }
    }
}


