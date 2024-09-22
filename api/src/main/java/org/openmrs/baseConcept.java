public class ConceptName extends BaseOpenmrsObject implements Auditable, Voidable, java.io.Serializable {
    // Fields
    private Integer conceptNameId;
    private String name;
    private Locale locale;
    private User creator;
    private Date dateCreated;
    private Boolean voided = false;
    private User voidedBy;
    private Date dateVoided;
    private String voidReason;

    // Constructors
    public ConceptName(Integer conceptNameId) {
        this.conceptNameId = conceptNameId;
    }

    public ConceptName(String name, Locale locale) {
        setName(name);
        setLocale(locale);
    }

    // Property accessors
    public Integer getConceptNameId() {
        return conceptNameId;
    }

    public void setConceptNameId(Integer conceptNameId) {
        this.conceptNameId = conceptNameId;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && StringUtils.isBlank(name) && StringUtils.isNotBlank(this.name)
                && this.getConceptNameType().equals(ConceptNameType.SHORT)) {
            this.setVoided(true);
        } else {
            this.name = name;
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

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
    @JsonIgnore
    public Boolean isVoided() {
        return getVoided();
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

    public Collection<ConceptNameTag> getTags() {
        // Implementation for getting tags
    }
}
