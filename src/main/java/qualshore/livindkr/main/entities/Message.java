package qualshore.livindkr.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 13/02/2018.
 */

@Entity
@Table(name = "message")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_message")
  private Integer idMessage;

  @Column(name = "corps")
  private String corps;

  @Column(name = "date_message")
  private Date dateMessage;

  @Column(name = "etat")
  private boolean etat;

  @JoinColumn(name = "id_envoyeur", referencedColumnName = "id_user")
  @ManyToOne(optional = false)
  private User idEnvoyeur;

  @JoinColumn(name = "id_receveur", referencedColumnName = "id_user")
  @ManyToOne(optional = false)
  private User idReceveur;

  public Message() {
  }

  public Integer getIdMessage() {
    return idMessage;
  }

  public void setIdMessage(Integer idMessage) {
    this.idMessage = idMessage;
  }

  public String getCorps() {
    return corps;
  }

  public void setCorps(String corps) {
    this.corps = corps;
  }

  public Date getDateMessage() {
    return dateMessage;
  }

  public void setDateMessage(Date dateMessage) {
    this.dateMessage = dateMessage;
  }

  public boolean isEtat() {
    return etat;
  }

  public void setEtat(boolean etat) {
    this.etat = etat;
  }

  public User getIdEnvoyeur() {
    return idEnvoyeur;
  }

  public void setIdEnvoyeur(User idEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
  }

  public User getIdReceveur() {
    return idReceveur;
  }

  public void setIdReceveur(User idReceveur) {
    this.idReceveur = idReceveur;
  }
}
