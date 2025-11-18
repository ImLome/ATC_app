package com.example.atc_app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atc_app.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private val messageList = mutableListOf<Message>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        binding.sendMessageButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun setupRecyclerView() {
        chatAdapter = ChatAdapter(messageList)
        binding.messagesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context).apply {
                stackFromEnd = true
            }
            adapter = chatAdapter
        }
    }

    private fun sendMessage() {
        val messageText = binding.messageEditText.text.toString()
        if (messageText.isNotBlank()) {
            val newMessage = Message(messageText, true)
            messageList.add(newMessage)
            chatAdapter.notifyItemInserted(messageList.size - 1)
            binding.messagesRecyclerView.scrollToPosition(messageList.size - 1)
            binding.messageEditText.text.clear()

            // Simulate a reply
            Handler(Looper.getMainLooper()).postDelayed({
                receiveReply()
            }, 1500)
        }
    }

    private fun receiveReply() {
        val reply = Message("Recibido, gracias.", false)
        messageList.add(reply)
        chatAdapter.notifyItemInserted(messageList.size - 1)
        binding.messagesRecyclerView.scrollToPosition(messageList.size - 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}