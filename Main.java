package ex3;

public class Main {
    public static void main(String[] args) throws RecordNotValid {
        PhoneBook pb = new PhoneBook();
        Record rd1 = new Record(1, "123456789", "hfgihgfyt");
        pb.createRecord(rd1);
        try {
            pb.createRecord(rd1);
        }
        catch (PhoneNumberAlreadyExists e) {
            System.out.println("данная запись уже существует");
        }

        Record rd2 = new Record(2, "987654321", "abcd");
        try {
            pb.updateRecord(rd2);
        } catch (RecordNotValid e) {
            System.out.println("данная запись некорректна");
        } catch (RecordNotFound e) {
            System.out.println("данная запись не существует");
        }

        try {
            pb.deleteRecord(2);
        }
        catch (RecordNotFound e) {
            System.out.println("данная запись не существует");
        }

    }
}
