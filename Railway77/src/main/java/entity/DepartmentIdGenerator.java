package entity;

import com.mysql.cj.xdevapi.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DepartmentIdGenerator  implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) {
        var department  = (Department) object;
        var type = department.getType();
        var hql = "SELECT COUNT(*) FROM Department WHERE type = : type";
        var count  = sharedSessionContractImplementor.createSelectionQuery(hql,Long.class)
                .setParameter("type",type)
                .uniqueResult();

        return type.toString().charAt(0) + " - " + (count + 1 ) ;
    }
}
