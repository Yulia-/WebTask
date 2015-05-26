package com.webapplication.servlet.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by ��� on 05.05.2015.
 */
public abstract class CommonModelBean implements Serializable {
    private static final long serialVersionUID = 5857934428639544639L;

    protected Object getIdModel() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdModel() == null) ? 0 : getIdModel().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CommonModelBean other = (CommonModelBean) obj;
        if (getIdModel() == null) {
            if (other.getIdModel() != null)
                return false;
        } else if (!getIdModel().equals(other.getIdModel()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}