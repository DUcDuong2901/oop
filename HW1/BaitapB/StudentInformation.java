package BaitapB;

public class StudentInformation {
    public static void main (String[] args)
    {
        String fullName = "Họ và Tên: Dương Minh Đức";
        String studentID = "Mã sinh viên: 22022606";
        String className = "Lớp: QH-2022-I/CQ-AI1";
        String githubUsername = "Username Github: DUcDuong2901";
        String email = "Email: 22022606@vnu.edu.vn";

        System.out.println(fullName + "\t" + studentID + "\t" + className + "\t" + githubUsername + "\t" + email);
        String s = "bottles of beer on the wall,";
        String x = "bottles of beer.";
        String c = "Take one down, pass it around,";
        for (int i=9; i>=1; i--)
        {
            System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
            System.out.println("Take one down, pass it around,");
        }
        System.out.println("No more bottles of beer on the wall.");
    }
}
