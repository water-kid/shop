package com.cj.shopback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 参数表
 * @TableName t_spec_param
 */
@TableName(value ="t_spec_param")
@Data
public class SpecParam implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 品类编号
     */
    private Integer spgId;

    /**
     * 参数编号
     */
    private Integer sppId;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 是否为数字参数
     */
    private Boolean numeric;

    /**
     * 单位(量词)
     */
    private String unit;

    /**
     * 是否为通用参数
     */
    private Boolean generic;

    /**
     * 是否用于通用搜索
     */
    private Boolean searching;

    /**
     * 参数值
     */
    private String segements;


    private Object details;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SpecParam other = (SpecParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpgId() == null ? other.getSpgId() == null : this.getSpgId().equals(other.getSpgId()))
            && (this.getSppId() == null ? other.getSppId() == null : this.getSppId().equals(other.getSppId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNumeric() == null ? other.getNumeric() == null : this.getNumeric().equals(other.getNumeric()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getGeneric() == null ? other.getGeneric() == null : this.getGeneric().equals(other.getGeneric()))
            && (this.getSearching() == null ? other.getSearching() == null : this.getSearching().equals(other.getSearching()))
            && (this.getSegements() == null ? other.getSegements() == null : this.getSegements().equals(other.getSegements()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpgId() == null) ? 0 : getSpgId().hashCode());
        result = prime * result + ((getSppId() == null) ? 0 : getSppId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumeric() == null) ? 0 : getNumeric().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getGeneric() == null) ? 0 : getGeneric().hashCode());
        result = prime * result + ((getSearching() == null) ? 0 : getSearching().hashCode());
        result = prime * result + ((getSegements() == null) ? 0 : getSegements().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spgId=").append(spgId);
        sb.append(", sppId=").append(sppId);
        sb.append(", name=").append(name);
        sb.append(", numeric=").append(numeric);
        sb.append(", unit=").append(unit);
        sb.append(", generic=").append(generic);
        sb.append(", searching=").append(searching);
        sb.append(", segements=").append(segements);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}