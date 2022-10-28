package ex3;

import java.util.ArrayList;

public class PhoneBook {

    protected ArrayList<Record> recList = new ArrayList<>();

    public ArrayList<Record> getAllRecords() {
        return recList;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        if (checkId(record)) {
            recList.add(record);
        } else {
            throw new PhoneNumberAlreadyExists();
        }
    }

    public void updateRecord(Record record) throws RecordNotValid, RecordNotFound {
        if (record.phoneNumber == null || record.name == null) {
            throw new RecordNotValid();
        }
        else {
            for (Record i : recList) {
                if (i.id == record.id) {
                    recList.remove(i);
                } else {
                    throw new RecordNotFound();
                }
            }
            recList.add(record);
        }


    }
    private boolean checkId(Record record) {
        for (Record i : recList) {
            if (i.id == record.id) {
                return false;
            }
        }
        return true;
    }

    public void deleteRecord(long id) throws RecordNotFound {
        if (!checkById(id))
            for (Record i : recList)
                if (i.id == id)
                    recList.remove(i);
        else
            throw new RecordNotFound();
    }
    private boolean checkById(long id) {
        for (Record i : recList) {
            if (i.id == id) {
                return true;
            }
        }
        return false;
    }

}
