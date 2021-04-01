using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

/// <summary>
/// Класс, реагирующий на нажатия пользователя.
/// </summary>
public class ControlManager : MonoBehaviour
{
    private ButtonScript _pauseButton; 
    private PlayerScript _player; 
    
    /// <summary>
    /// Метод Start, вызывается при запуске сцены
    /// </summary>
    void Start()
    {
        _pauseButton = GameObject.FindGameObjectWithTag("PauseButton").GetComponent<ButtonScript>();
        _player = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerScript>();
    }

    /// <summary>
    /// Метод Update, вызывается при каждом новом кадре
    /// </summary>
    void Update()
    {
        if ((Input.GetKey("x"))||(Input.touchCount > 0 && !_pauseButton.buttonWasClicked()))
        {
            _player.Jump();
        }
    }
}
