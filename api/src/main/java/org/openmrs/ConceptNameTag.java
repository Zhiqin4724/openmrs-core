/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, you can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.envers.Audited;

/**
 * ConceptNameTag is a textual tag which can be applied to a ConceptName.
 */
@Audited
public class ConceptNameTag extends BaseConcept implements Auditable, Voidable, java.io.Serializable {
	
	public static final long serialVersionUID = 33226787L;
	
	// Fields
	private Integer conceptNameTagId; // Unique identifier for the ConceptNameTag
	private String tag; // The textual representation of the tag
	private String description; // Description of the tag
	private User creator; // User who created this tag
	private Date dateCreated; // Date when this tag was created
	private Boolean voided = false; // Indicates if the tag is voided
	private User voidedBy; // User who voided this tag
	private Date dateVoided; // Date when this tag was voided
	private String voidReason; // Reason for voiding the tag
	private User changedBy; // User who last changed this tag
	private Date dateChanged; // Date when this tag was last changed
	
	// Constructors
	
	/** Default constructor. */
	public ConceptNameTag() {
	}
	
	/**
	 * Public constructor to initialize a tag and its description.
	 * 
	 * @param tag the textual representation of the tag
	 * @param description the description of the tag
	 */
	public ConceptNameTag(String tag, String description) {
		setTag(tag);
		setDescription(description);
	}
	
	// Property accessors
	
	/**
	 * Returns the textual representation of this ConceptNameTag.
	 * 
	 * @return the textual representation of this ConceptNameTag.
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Sets the textual representation of this ConceptNameTag.
	 * 
	 * @param tag the textual representation to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * Returns the description of this tag.
	 * 
	 * @return the description of this tag
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description of this tag.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Returns the creator of this tag.
	 * 
	 * @return the creator
	 */
	@Override
	public User getCreator() {
		return creator;
	}
	
	/**
	 * Sets the creator of this tag.
	 * 
	 * @param creator the creator to set
	 */
	@Override
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	/** 
	 * Returns the date this tag was created.
	 * 
	 * @return the date created
	 */
	@Override
	public Date getDateCreated() {
		return dateCreated;
	}
	
	/**
	 * Sets the date this tag was created.
	 * 
	 * @param dateCreated the date created to set
	 */
	@Override
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	/**
	 * Returns whether the tag has been voided.
	 * 
	 * @return true if the tag has been voided, false otherwise
	 * @deprecated as of 2.0, use {@link #getVoided()} instead
	 */
	@Override
	@Deprecated
	@JsonIgnore
	public Boolean isVoided() {
		return getVoided();
	}
	
	/**
	 * Returns whether the tag has been voided.
	 * 
	 * @return true if the tag has been voided, false otherwise
	 */
	@Override
	public Boolean getVoided() {
		return voided;
	}
	
	/**
	 * Sets the voided status of the tag.
	 * 
	 * @param voided the voided status to set
	 */
	@Override
	public void setVoided(Boolean voided) {
		this.voided = voided;
	}
	
	/**
	 * Returns the User who voided this tag.
	 * 
	 * @return the User who voided this tag, or null if not set
	 */
	@Override
	public User getVoidedBy() {
		return voidedBy;
	}
	
	/**
	 * Sets the User who voided this tag.
	 * 
	 * @param voidedBy the user who voided this tag
	 */
	@Override
	public void setVoidedBy(User voidedBy) {
		this.voidedBy = voidedBy;
	}
	
	/**
	 * Returns the Date this tag was voided.
	 * 
	 * @return the Date this tag was voided
	 */
	@Override
	public Date getDateVoided() {
		return dateVoided;
	}
	
	/**
	 * Sets the Date this tag was voided.
	 * 
	 * @param dateVoided the date this tag was voided
	 */
	@Override
	public void setDateVoided(Date dateVoided) {
		this.dateVoided = dateVoided;
	}
	
	/**
	 * Returns the reason this tag was voided.
	 * 
	 * @return the reason this tag was voided
	 */
	@Override
	public String getVoidReason() {
		return voidReason;
	}
	
	/**
	 * Sets the reason this tag was voided.
	 * 
	 * @param voidReason the reason this tag was voided
	 */
	@Override
	public void setVoidReason(String voidReason) {
		this.voidReason = voidReason;
	}
	
	@Override
	public String toString() {
		return this.tag; // Returns the tag as a string representation
	}
	
	/**
	 * Returns the conceptNameTagId.
	 * 
	 * @return the conceptNameTagId
	 */
	public Integer getConceptNameTagId() {
		return conceptNameTagId;
	}
	
	/**
	 * Sets the conceptNameTagId.
	 * 
	 * @param conceptNameTagId the conceptNameTagId to set
	 */
	public void setConceptNameTagId(Integer conceptNameTagId) {
		this.conceptNameTagId = conceptNameTagId;
	}
	
	/**
	 * @since 1.5
	 * @see org.openmrs.OpenmrsObject#getId()
	 */
	@Override
	public Integer getId() {
		return getConceptNameTagId();
	}
	
	/**
	 * @since 1.5
	 * @see org.openmrs.OpenmrsObject#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		setConceptNameTagId(id);
	}
	
	/**
	 * Returns the User who changed this tag.
	 * 
	 * @return the changedBy
	 */
	@Override
	public User getChangedBy() {
		return changedBy;
	}
	
	/**
	 * Sets the User that changed this tag.
	 * 
	 * @param changedBy the user that changed this tag
	 */
	@Override
	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}
	
	/**
	 * Returns the date this tag was last changed.
	 * 
	 * @return the date this tag was changed
	 */
	@Override
	public Date getDateChanged() {
		return dateChanged;
	}
	
	/**
	 * Sets the date this tag was last changed.
	 * 
	 * @param dateChanged the date this tag was changed
	 */
	@Override
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
}
