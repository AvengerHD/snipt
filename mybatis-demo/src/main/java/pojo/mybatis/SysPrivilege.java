package pojo.mybatis;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`mybatis..sys_privilege`")
public class SysPrivilege implements Serializable {
    /**
     * 权限ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名称
     */
    @Column(name = "`privilege_name`")
    private String privilegeName;

    /**
     * 权限URL
     */
    @Column(name = "`privilege_url`")
    private String privilegeUrl;

    private static final long serialVersionUID = 1L;

    /**
     * 获取权限ID
     *
     * @return id - 权限ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置权限ID
     *
     * @param id 权限ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取权限名称
     *
     * @return privilege_name - 权限名称
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     * 设置权限名称
     *
     * @param privilegeName 权限名称
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    /**
     * 获取权限URL
     *
     * @return privilege_url - 权限URL
     */
    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    /**
     * 设置权限URL
     *
     * @param privilegeUrl 权限URL
     */
    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl == null ? null : privilegeUrl.trim();
    }

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
        SysPrivilege other = (SysPrivilege) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrivilegeName() == null ? other.getPrivilegeName() == null : this.getPrivilegeName().equals(other.getPrivilegeName()))
            && (this.getPrivilegeUrl() == null ? other.getPrivilegeUrl() == null : this.getPrivilegeUrl().equals(other.getPrivilegeUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrivilegeName() == null) ? 0 : getPrivilegeName().hashCode());
        result = prime * result + ((getPrivilegeUrl() == null) ? 0 : getPrivilegeUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", privilegeName=").append(privilegeName);
        sb.append(", privilegeUrl=").append(privilegeUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}