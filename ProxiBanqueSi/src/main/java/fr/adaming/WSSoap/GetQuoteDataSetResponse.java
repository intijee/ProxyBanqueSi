
package fr.adaming.WSSoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetQuoteDataSetResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQuoteDataSetResult"
})
@XmlRootElement(name = "GetQuoteDataSetResponse")
public class GetQuoteDataSetResponse {

    @XmlElement(name = "GetQuoteDataSetResult")
    protected GetQuoteDataSetResponse.GetQuoteDataSetResult getQuoteDataSetResult;

    /**
     * Obtient la valeur de la propri�t� getQuoteDataSetResult.
     * 
     * @return
     *     possible object is
     *     {@link GetQuoteDataSetResponse.GetQuoteDataSetResult }
     *     
     */
    public GetQuoteDataSetResponse.GetQuoteDataSetResult getGetQuoteDataSetResult() {
        return getQuoteDataSetResult;
    }

    /**
     * D�finit la valeur de la propri�t� getQuoteDataSetResult.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQuoteDataSetResponse.GetQuoteDataSetResult }
     *     
     */
    public void setGetQuoteDataSetResult(GetQuoteDataSetResponse.GetQuoteDataSetResult value) {
        this.getQuoteDataSetResult = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class GetQuoteDataSetResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Obtient la valeur de la propri�t� any.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * D�finit la valeur de la propri�t� any.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
