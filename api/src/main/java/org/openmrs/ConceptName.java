package org.openmrs;

import org.openmrs.annotation.Audited;
import org.openmrs.annotation.Indexed;
import org.openmrs.annotation.AnalyzerDef;
import org.openmrs.annotation.TokenizerDef;
import org.openmrs.annotation.TokenFilterDef;
import org.openmrs.annotation.FieldBridge;
import org.openmrs.annotation.Field;
import org.openmrs.util.LocaleFieldBridge;

import java.util.Collection;
import java.util.Locale;

@Indexed
@AnalyzerDef(
    name = "ConceptNameAnalyzer",
    tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
    filters = {
        @TokenFilterDef(factory = StandardFilterFactory.class),
        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
        @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class)
    }
)
@Analyzer(definition = "ConceptNameAnalyzer")
@Audited
public class ConceptName extends BaseConcept implements Auditable, Voidable, java.io.Serializable {

    public static final long serialVersionUID = 2L;

    @DocumentId
    private Integer conceptNameId;

    @IndexedEmbedded(includeEmbeddedObjectId = true)
    private Concept concept;

    @Field
    private String name;

    @Field(analyze = Analyze.NO)
    @FieldBridge(impl = LocaleFieldBridge.class)
    private Locale locale;

    @Field
    private Boolean localePreferred = false;

    private Collection<ConceptNameTag> tags;

    // Constructors
    public ConceptName() {
    }

    public ConceptName(Integer conceptNameId, Concept concept, String name, Locale locale, Boolean localePreferred) {
        this.conceptNameId = conceptNameId;
        this.concept = concept;
        this.name = name;
        this.locale = locale;
        this.localePreferred = localePreferred;
    }

    // Getters and Setters
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
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Boolean getLocalePreferred() {
        return localePreferred;
    }

    public void setLocalePreferred(Boolean localePreferred) {
        this.localePreferred = localePreferred;
    }

    public Collection<ConceptNameTag> getTags() {
        return tags;
    }

    public void setTags(Collection<ConceptNameTag> tags) {
        this.tags = tags;
    }

    // Implement other methods from Auditable and Voidable interfaces
    // For example:
    @Override
    public User getCreator() {
        return creator; // From BaseConcept
    }

    @Override
    public Date getDateCreated() {
        return dateCreated; // From BaseConcept
    }

    @Override
    public User getChangedBy() {
        return changedBy; // From BaseConcept
    }

    @Override
    public Date getDateChanged() {
        return dateChanged; // From BaseConcept
    }

    @Override
    public Boolean getVoided() {
        return voided; // From BaseConcept
    }

    @Override
    public User getVoidedBy() {
        return voidedBy; // From BaseConcept
    }

    @Override
    public Date getDateVoided() {
        return dateVoided; // From BaseConcept
    }

    @Override
    public String getVoidReason() {
        return voidReason; // From BaseConcept
    }

    // Additional methods as needed...
}
