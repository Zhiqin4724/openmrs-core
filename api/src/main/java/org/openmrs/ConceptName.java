package org.openmrs;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;
import org.openmrs.api.ConceptNameType;
import org.openmrs.api.db.hibernate.search.bridge.LocaleFieldBridge;

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
public class ConceptName extends ConceptBase {

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
    
    private Collection<ConceptNameTag> tags;
    
    @Field
    private ConceptNameType conceptNameType;
    
    @Field
    private Boolean localePreferred = false;
    
    // Constructors
    
    public ConceptName() {
    }
    
    public ConceptName(Integer conceptNameId) {
        this.conceptNameId = conceptNameId;
    }
    
    public ConceptName(String name, Locale locale) {
        setName(name);
        setLocale(locale);
    }
    
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

    public Collection<ConceptNameTag> getTags() {
        return tags;
    }
    
    public void setTags(Collection<ConceptNameTag> tags) {
        this.tags = tags;
    }
    
    public ConceptNameType getConceptNameType() {
        return this.conceptNameType;
    }
    
    public void setConceptNameType(ConceptNameType conceptNameType) {
        this.conceptNameType = conceptNameType;
    }
    
    public Boolean getLocalePreferred() {
        return localePreferred;
    }
    
    public void setLocalePreferred(Boolean localePreferred) {
        this.localePreferred = localePreferred;
    }
    
    // Other methods (addTag, removeTag, hasTag, etc.) remain unchanged
    
    @Override
    public String toString() {
        return this.name == null ? "ConceptNameId: " + this.conceptNameId : this.name;
    }
    
    @Override
    public Integer getId() {
        return getConceptNameId();
    }
    
    @Override
    public void setId(Integer id) {
        setConceptNameId(id);
    }
}
