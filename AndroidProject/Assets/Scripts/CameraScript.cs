using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraScript : MonoBehaviour
{
    private PlayerScript _player;
    private float _playerY = 0;
    void Start()
    {
        _player = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerScript>();
    }

    public void SetPlayerY(float playerY)
    {
        _playerY = playerY;
    }

    // Update is called once per frame
    void Update()
    {
        transform.position = Vector3.Lerp(transform.position,new Vector3(_player.transform.position.x + 5, _playerY, transform.position.z), 0.02f);
    }
}
