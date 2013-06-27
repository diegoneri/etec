package br.com.etec.view.listener;

import br.com.etec.view.event.AbstractEvent;

/**
 * Contrato para componentes com a capacidade de definir tratamento adequado
 * para um evento.
 *
 * <p> Em conjunto com
 * <code>AbstractController</code> e
 * <code>AbstractEvent</code>, esse componente é parte do trecho que implementa
 * o design pattern <strong>Observer</strong>. </p>
 *
 * <p><code>AbstractEventListener</code> atua como <i>observador</i>.</p>
 *
 * @see br.com.yaw.sjpac.event.AbstractEvent
 *
 * @author dfelix3
 *
 * @param <M> tipo do Evento que deverá ser tratado.
 */
public interface AbstractEventListener<M extends AbstractEvent<?>> {

    public void handleEvent(M event);
}
