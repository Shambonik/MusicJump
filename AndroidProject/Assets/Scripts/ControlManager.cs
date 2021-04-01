using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ControlManager : MonoBehaviour
{
    private ButtonScript _pauseButton; 
    private PlayerScript _player; 
    
    // Start is called before the first frame update
    void Start()
    {
        _pauseButton = GameObject.FindGameObjectWithTag("PauseButton").GetComponent<ButtonScript>();
        _player = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerScript>();
    }

    // Update is called once per frame
    void Update()
    {
        if ((Input.GetKey("x"))||(Input.touchCount > 0 && !_pauseButton.buttonWasClicked()))
        {
            _player.Jump();
        }
    }
}
