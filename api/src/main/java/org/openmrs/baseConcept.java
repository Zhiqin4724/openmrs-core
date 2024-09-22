package org.openmrs;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class BaseConcept extends BaseOpenmrsObject implements Auditable, Voidable, java.io.Serializable {

    private User creator;
    private Date dateCreated;
    private Boolean voided = false;
    private User voidedBy;
    private Date dateVoided;
    private String voidReason;
    private User changedBy;
    private Date dateChanged;

    @Override
    public User getCreator() {
        return creator;
    }

    @Override
    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public Boolean getVoided() {
        return voided;
    }

    @Override
    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    @Override
    public User getVoidedBy() {
        return voidedBy;
    }

    @Override
    public void setVoidedBy(User voidedBy) {
        this.voidedBy = voidedBy;
    }

    @Override
    public Date getDateVoided() {
        return dateVoided;
    }

    @Override
    public void setDateVoided(Date dateVoided) {
        this.dateVoided = dateVoided;
    }

    @Override
    public String getVoidReason() {
        return voidReason;
    }

    @Override
    public void setVoidReason(String voidReason) {
        this.voidReason = voidReason;
    }

    @Override
    public User getChangedBy() {
        return changedBy;
    }

    @Override
    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public Date getDateChanged() {
        return dateChanged;
    }

    @Override
    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
}
