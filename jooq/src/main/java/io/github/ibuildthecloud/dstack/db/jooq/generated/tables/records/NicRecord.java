/**
 * This class is generated by jOOQ
 */
package io.github.ibuildthecloud.dstack.db.jooq.generated.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "nic", schema = "dstack")
public class NicRecord extends org.jooq.impl.UpdatableRecordImpl<io.github.ibuildthecloud.dstack.db.jooq.generated.tables.records.NicRecord> implements org.jooq.Record11<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -1627059988;

	/**
	 * Setter for <code>dstack.nic.id</code>. 
	 */
	public NicRecord setId(java.lang.Long value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 19)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>dstack.nic.instance_id</code>. 
	 */
	public NicRecord setInstanceId(java.lang.Long value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.instance_id</code>. 
	 */
	@javax.persistence.Column(name = "instance_id", nullable = false, precision = 19)
	public java.lang.Long getInstanceId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>dstack.nic.network_id</code>. 
	 */
	public NicRecord setNetworkId(java.lang.Long value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.network_id</code>. 
	 */
	@javax.persistence.Column(name = "network_id", nullable = false, precision = 19)
	public java.lang.Long getNetworkId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>dstack.nic.account_id</code>. 
	 */
	public NicRecord setAccountId(java.lang.Long value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.account_id</code>. 
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 19)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>dstack.nic.state</code>. 
	 */
	public NicRecord setState(java.lang.String value) {
		setValue(4, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.state</code>. 
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 255)
	public java.lang.String getState() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>dstack.nic.mac_address</code>. 
	 */
	public NicRecord setMacAddress(java.lang.String value) {
		setValue(5, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.mac_address</code>. 
	 */
	@javax.persistence.Column(name = "mac_address", length = 17)
	public java.lang.String getMacAddress() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>dstack.nic.device_number</code>. 
	 */
	public NicRecord setDeviceNumber(java.lang.Integer value) {
		setValue(6, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.device_number</code>. 
	 */
	@javax.persistence.Column(name = "device_number", nullable = false, precision = 10)
	public java.lang.Integer getDeviceNumber() {
		return (java.lang.Integer) getValue(6);
	}

	/**
	 * Setter for <code>dstack.nic.uuid</code>. 
	 */
	public NicRecord setUuid(java.lang.String value) {
		setValue(7, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", nullable = false, length = 255)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>dstack.nic.created</code>. 
	 */
	public NicRecord setCreated(java.sql.Timestamp value) {
		setValue(8, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.created</code>. 
	 */
	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(8);
	}

	/**
	 * Setter for <code>dstack.nic.removed</code>. 
	 */
	public NicRecord setRemoved(java.sql.Timestamp value) {
		setValue(9, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.removed</code>. 
	 */
	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return (java.sql.Timestamp) getValue(9);
	}

	/**
	 * Setter for <code>dstack.nic.remove_time</code>. 
	 */
	public NicRecord setRemoveTime(java.sql.Timestamp value) {
		setValue(10, value);
		return this;
	}

	/**
	 * Getter for <code>dstack.nic.remove_time</code>. 
	 */
	@javax.persistence.Column(name = "remove_time")
	public java.sql.Timestamp getRemoveTime() {
		return (java.sql.Timestamp) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.INSTANCE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.NETWORK_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.MAC_ADDRESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.DEVICE_NUMBER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field9() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field10() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.REMOVED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field11() {
		return io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC.REMOVE_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value2() {
		return getInstanceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getNetworkId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getMacAddress();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value7() {
		return getDeviceNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getUuid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value9() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value10() {
		return getRemoved();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value11() {
		return getRemoveTime();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached NicRecord
	 */
	public NicRecord() {
		super(io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC);
	}

	/**
	 * Create a detached, initialised NicRecord
	 */
	public NicRecord(java.lang.Long id, java.lang.Long instanceId, java.lang.Long networkId, java.lang.Long accountId, java.lang.String state, java.lang.String macAddress, java.lang.Integer deviceNumber, java.lang.String uuid, java.sql.Timestamp created, java.sql.Timestamp removed, java.sql.Timestamp removeTime) {
		super(io.github.ibuildthecloud.dstack.db.jooq.generated.tables.Nic.NIC);

		setValue(0, id);
		setValue(1, instanceId);
		setValue(2, networkId);
		setValue(3, accountId);
		setValue(4, state);
		setValue(5, macAddress);
		setValue(6, deviceNumber);
		setValue(7, uuid);
		setValue(8, created);
		setValue(9, removed);
		setValue(10, removeTime);
	}
}