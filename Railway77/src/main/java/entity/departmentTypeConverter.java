package entity;

import jakarta.persistence.AttributeConverter;

public class departmentTypeConverter implements AttributeConverter<Department.Type, Character> {
    @Override
    public Character convertToDatabaseColumn(Department.Type type) {
        return type.toString().charAt(0); //lấy chữ cái đầu tiên enum
    }

    @Override
    public Department.Type convertToEntityAttribute(Character code) {
        if(code == 'D') {
            return Department.Type.DEVELOPER;
        }
        if(code == 'T') {
            return Department.Type.TESTER;
        }
        if(code == 'S') {
            return Department.Type.SCRUM_MASTER;
        }

     return Department.Type.PROJECT_MANAGER;
    }
}
