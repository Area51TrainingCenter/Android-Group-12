package com.johannfjs.models;

import java.util.Date;

/**
 * Created by johannfjs on 23/03/15.
 */
public class Empresa {
    private String objectId;
    private String nombreEmpresa;
    private String ruc;
    private Date createAt;
    private Date updatedAt;

    public Empresa(String objectId, String nombreEmpresa, String ruc, Date createAt, Date updatedAt) {
        this.objectId = objectId;
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
