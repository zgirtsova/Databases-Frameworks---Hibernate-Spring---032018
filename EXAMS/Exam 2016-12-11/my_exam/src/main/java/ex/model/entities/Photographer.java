package ex.model.entities;

import ex.model.validation.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class    Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //тук няма да пишем никакъв custom validation, ще сложим такъв в DTO-то
    @Basic
    @Phone
    //когато @Phone е тук, РАБОТИ и не вкарва грешни телефони в базата
    private String phone;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_camera_id")
    private BasicCamera primaryCamera;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "secondary_camera_id")
    private BasicCamera secondaryCamera;


    @OneToMany(mappedBy = "owner")
    private Set<Accessory> accessorySet;

    @OneToMany(mappedBy = "owner")
    private Set<Lens> lensSet;

    // на кои workshop-и е трейнър този фотограф
    @OneToMany(mappedBy = "trainer")
    private Set<Workshop> trainerIn;

    // Къде участва, в кой уъркшоп
    @ManyToMany(mappedBy = "participants")
    private Set<Workshop> participatesIn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(BasicCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCamera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<Accessory> getAccessorySet() {
        return accessorySet;
    }

    public void setAccessorySet(Set<Accessory> accessorySet) {
        this.accessorySet = accessorySet;
    }

    public Set<Lens> getLensSet() {
        return lensSet;
    }

    public void setLensSet(Set<Lens> lensSet) {
        this.lensSet = lensSet;
    }

    public Set<Workshop> getTrainerIn() {
        return trainerIn;
    }

    public void setTrainerIn(Set<Workshop> trainerIn) {
        this.trainerIn = trainerIn;
    }

    public Set<Workshop> getParticipatesIn() {
        return participatesIn;
    }

    public void setParticipatesIn(Set<Workshop> participatesIn) {
        this.participatesIn = participatesIn;
    }
}
