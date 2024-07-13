package com.example.businesslogic.models.flower.suppliers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Table(schema = "flowers", name = "contact_supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    Long id;

    @Column(name = "supplier_contact")
    private String contactPhone;

    @Column(name = "supplier_name")
    private String contactName;

    @Column(name = "supplier_email")
    private String email;

    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    public static class ContactBuilder {
        private Long id;
        private String contactPhone;
        private String contactName;
        private String email;
        private Supplier suppliers;

        ContactBuilder() {
        }

        public ContactBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ContactBuilder contactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public ContactBuilder contactName(String contactName) {
            this.contactName = contactName;
            return this;
        }

        public ContactBuilder email(String email) {
            this.email = email;
            return this;
        }


        public Contact build() {
            return new Contact(this.id, this.contactPhone, this.contactName, this.email);
        }

        public String toString() {
            return "Contact.ContactBuilder(id=" + this.id + ", contactPhone=" + this.contactPhone + ", contactName=" + this.contactName + ", email=" + this.email + ", suppliers=" + this.suppliers + ")";
        }
    }
}
